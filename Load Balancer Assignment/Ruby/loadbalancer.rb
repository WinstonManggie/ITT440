require "socket"

loadbalancer = TCPServer.open("192.168.80.129",2000)

while true
	client = loadbalancer.accept

	rhost = clien.peeraddr.last
	puts "#{rhost} connect to load balancer"

	fromclient = client.gets
	puts "MESSAGE FROM CLIENT: #{fromclient}"

	if fromclient == "white"
		sockettoserver1 = TCPSocket.open("192.168.17.129",3000)
		sockettoserver1.write(fromclient)
		sockettoserver1.close

	elsif fromclient == "black"
		sockettoserver2 = TCPSocket.open("192.168.17.130",4000)
		sockettoserver2.write(fromclient)
		sockettoserver2.close

	else
		puts "ERROR"

	end
end