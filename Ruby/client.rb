require "socket"
client = TCPSocket.open("192.168.80.129",2000)

puts "ENTER YOUR MESSAGE: "
message = gets.chomp

rhost = client.peeraddr.last
puts "#{rhost}"
client.write(message)
client.close