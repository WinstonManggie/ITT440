#include <stdio.h>
#include <string.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <unistd.h>

int main(){
	int sock;
	struct sockaddr_in server;
	char message[3000];
	
	sock=socket(AF_INET,SOCK_STREAM,0);
	if(sock==-1){
	   printf("COULD NOT CREATE SOCKET");
	}
	puts("SOCKET CREATED");

	server.sin_addr.s_addr=inet_addr("192.168.80.129");
	server.sin_family=AF_INET;
	server.sin_port=htons(1000);

	if(connect(sock,(struct sockaddr *)&server,sizeof(server))<0){
		perror("FAILED TO CONNECT TO LOAD BALANCER");
		return 1;
	}

	printf("ENTER YOUR MESSAGE");
	scanf("%s",message);
	if(send(sock,message,strlen(message),0)<0){
	puts("FAILED TO SEND");
	return 1;
	}
	close(sock);
	
return 0;
}
