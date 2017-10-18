require 'socket'

server = TCPServer.open('192.168.62.132', 2000)
loop {
	client = server.accept
	client.puts(Time.now.ctime)
	client.puts "Closing the connection. Bye!"
	client.close
}
