

const stompClient = new StompJs.Client({
  brokerURL: 'ws://localhost:8080/ws'
});

stompClient.onConnect = (frame) => {
  console.log('Connected: ' + frame);

  // 구독 설정: 서버에서 클라이언트로 메시지 수신을 위한 구독
  stompClient.subscribe('/topic/messages', (message) => {
    console.log('Received message:', message.body);
    // 메시지 수신 후 처리
  });

  // 메시지 전송: 클라이언트에서 서버로 메시지 전송
  stompClient.publish({
    destination: '/app/sendMessage', // 백엔드의 컨트롤러 매핑 경로
    body: JSON.stringify({ documentIdx: 'Hello, Server!' }) // 전송할 데이터
  });
};

stompClient.activate();