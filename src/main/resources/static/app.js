var docsIdxPage = document.querySelector('#docs-idx-page');
var docsPage = document.querySelector('#docs-page');
var docsIdxForm = document.querySelector('#docsIdxForm');
var docsForm = document.querySelector('#docsForm');
// var messageInput = document.querySelector('#message');
var docsArea = document.querySelector('#docsArea');
var connectingElement = document.querySelector('.connecting');

var stompClient = null;
var docsIdx = null;

var colors = [
  '#2196F3', '#32c787', '#00BCD4', '#ff5652',
  '#ffc107', '#ff85af', '#FF9800', '#39bbb0'
];

function connect(event) {
  event.preventDefault();

  var docsIdxInput = document.getElementById('docs-idx');
  docsIdx = docsIdxInput.value.trim();

  if (docsIdx) {
    var socket = new SockJS('/ws');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, onConnect, onError);
  }
}

function onConnect() {
  var docsIdxInput = document.getElementById('docs-idx');
  docsIdx = docsIdxInput.value.trim(); // docsIdx를 재설정

  stompClient.subscribe('/topic/public', function (docs) {
    displayDocs(JSON.parse(docs.body));
  });

  var docsMessage = {
    documentIdx: docsIdx,
  };
  stompClient.send("/app/chat.showDocs", {}, JSON.stringify(docsMessage));
}

function onError(error) {
  connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
  connectingElement.style.color = 'red';
}

// 문서를 표시하는 함수
function displayDocs(docs) {
  var docsTitleElement = document.getElementById('docsTitle');
  var docsContentElement = document.getElementById('docsContent');

  // 서버로부터 받은 문서 정보를 화면에 표시
  docsTitleElement.textContent = docs.title;
  docsContentElement.textContent = docs.content;
}

var docsIdxForm = document.getElementById('docsIdxForm');
docsIdxForm.addEventListener('submit', connect);