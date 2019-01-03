# Introduction to the Internet

# Objectives
- Fellows will explore the concept of the Internet
- Fellows will learn the difference between a Server and a Client
- Fellows will identify IP Addresses and DNS 

# Lecture

## What is the Internet?

The Internet is the backbone of the Web, the infrastructure that makes the Web possible. In essence, the Internet is a large network of computers which all communicate together.

What started in the 1960s as a US military research project, soon evolved into a public infrastructure. The various technologies that support the Internet have evolved over time, but the way it works hasn't changed that much: Internet is a way to connect computers all together.

![Internet](assets/internet.jpg)

### Client vs. Server

Computers connected to the web are called **clients** and **servers**. A simplified diagram of how they interact might look like this:

![](https://mdn.mozillademos.org/files/8973/Client-server.jpg)

- Clients are the web user's internet-connected devices (phone, computer, etc.) and the web-accessing software available on those devices (chrome, firefox, etc.).
- Servers are computers that store webpages, sites, or apps. When a client device wants to access a webpage, a copy of the webpage is downloaded from the server onto the client machine to be displayed in the user's web browser.

### So what happens, exactly?

When you type a web address into your browser:

1. The browser goes to the DNS server, and finds the real address of the server that the website lives on.
2. The browser sends an HTTP request message to the server, asking it to send a copy of the website to the client.
3. Provided the server approves the client's request, the server sends the client a "200 OK" message, and then starts sending the website's files to the browser as a series of small chunks called data packets.
4. The browser assembles the small chunks into a complete website and displays it.

## What's a Server?

A server is basically just a computer designed to take requests and send back responses. The word "server" is understood by most to mean a web server where webpages can be accessed over the internet through a client like a web browser.

### Types of Servers
1. **Web server**: Web servers show pages and run apps through web browsers. The server your browser is connected to right now is a web server that's delivering this page and any images you see on it. 
2. **Email server**: Email servers facilitate the sending and receiving of email messages.
3. **FTP server**: FTP servers support the moving of files through File Transfer Protocol tools

## What's a Client?

A client is any computer program or machine that makes a request to a server. 

### Types of Clients

1. **Web Browser:** Your Web browser is a special program that is built to send requests to the internet and retrieve responses. The browser then portrays the data to you.
2. **Mobile App:** Any app that is connecting to the internet to retrieve data is a client (often JSON).

## IP Addresses & DNS

### Finding computers

* Source: [*How does the Internet work?* by mozilla contributors](https://developer.mozilla.org/en-US/docs/Learn/Common_questions/How_does_the_Internet_work)

A computer connected to a network has a unique identifier known as an IP address _(internet protocol)_. An example of an IP address would be 192.168.2.10

That IP address is perfectly fine for computers, but for human readability we use an alias called the **domain name**. For example, apple.com is the domain name used on top of the IP address 17.142.160.59 So using the domain name is the easiest way for us to reach a computer on the internet. Websites can be reached directly using their IP address. You can find the IP address of a website by typing its domain into a tool like [IP Checker](https://ipinfo.info/html/ip_checker.php)

**Clarification**  
The internet is a technical infrastructure which allows billions of computers to be connected all together. Among those computers, some computers (called Web servers) can send messages intelligle to web browsers. The internet is an infrastructure, whereas the _Web_ is a service built on top of the infrastructure. Some other services on top the internet, are email and IRC.

If you want to send a message to a computer, you have to specify which one. Thus any computer linked to a network has a unique address to identify it, called an **IP address**. It's an address made of a series of four numbers separated by dots, for example: `192.168.2.10`.

To make things easier for humans, IP addresses usually have a human readable alias called a **domain name**. For example, `google.com` is the domain name used on top of the IP address `173.194.121.32`. Using the domain name is the easiest way for us to reach a computer over the Internet.

![Show how a domain name can alias an IP address](https://mdn.mozillademos.org/files/8405/dns-ip.png)

The client and server we've described above don't tell the whole story. There are many other parts involved, and we'll describe some of them below.

* **DNS**: Domain Name Servers are like an address book for websites. When you type a web address in your browser, the DNS needs to be reached first to translate the address to an ip address.
* **HTTP** (Hypertext Transfer Protocol): a protocol that defines  how clients and servers speak to each other.
* **Component files**: A website is made up of many different files, which are like the different parts of the goods you buy from the shop. These files come in two main types:
  * **Code files**: Websites are built primarily built from HTML, CSS, and JavaScript.
  * **Assets**: All the other stuff that makes up a website, such as images, music, video, Word documents, and PDFs.

When you type a web address into your browser: 

1. The browser goes to teh DNS server, and finds the real address of the server that the website lives on. 
2. The browser sends an HTTP request message to the server, asking it to send a copy of the the website to the client. The message, and all other data sent between the client and the server, is send across your internet connection using TCP/IP. 
3. If the server approves the client's request, the server send the client a "200 Ok" message, which means "of course you can look at that website, here it is" and then starts sending the website's files to the browser as a series of small chunks called data packets. 
4. The browser assembles the small chunks into a complete website and displays it to you. 


**Let's see what a request -> response looks like using curl**   
Go to your terminal and type in the following [curl](https://en.wikipedia.org/wiki/CURL) command:

The command below makes a requst to the following website  

```curl -I https://www.apple.com```

The above curl command will give you header infomation of the requested website

> HTTP/1.1 200 OK  
Server: Apache  
X-Frame-Options: SAMEORIGIN  
X-Xss-Protection: 1; mode=block  
X-Content-Type-Options: nosniff  
Content-Type: text/html; charset=UTF-8  
Cache-Control: max-age=134  
Expires: Sun, 02 Dec 2018 14:28:42 GMT  
Date: Sun, 02 Dec 2018 14:26:28 GMT  
Connection: keep-alive  
Set-Cookie: geo=US; path=/; domain=.apple.com  
Set-Cookie: ccl=a/ku6WIhzEikkJn6N+c0h1NGAKDJgMgek4hZeH4vjQc=; path=/; domain=.apple.com  

Using curl to make a request to an [API](https://en.wikipedia.org/wiki/Web_API) (more about APIs in this current unit)   
```curl https://itunes.apple.com/search?term=swift+over+coffee&media=podcast```  

[JSON](https://json.org/) response
```json 
{
	"resultCount": 1,
	"results": [{
		"wrapperType": "track",
		"kind": "podcast",
		"collectionId": 1435076502,
		"trackId": 1435076502,
		"artistName": "Paul Hudson and Sean Allen",
		"collectionName": "Swift over Coffee",
		"trackName": "Swift over Coffee",
		"collectionCensoredName": "Swift over Coffee",
		"trackCensoredName": "Swift over Coffee",
		"collectionViewUrl": "https://itunes.apple.com/us/podcast/swift-over-coffee/id1435076502?mt=2&uo=4",
		"feedUrl": "https://anchor.fm/s/572fc68/podcast/rss",
		"trackViewUrl": "https://itunes.apple.com/us/podcast/swift-over-coffee/id1435076502?mt=2&uo=4",
		"artworkUrl30": "https://is2-ssl.mzstatic.com/image/thumb/Music118/v4/73/24/2c/73242c65-1b6f-0dce-9740-fa84a92607e1/source/30x30bb.jpg",
		"artworkUrl60": "https://is2-ssl.mzstatic.com/image/thumb/Music118/v4/73/24/2c/73242c65-1b6f-0dce-9740-fa84a92607e1/source/60x60bb.jpg",
		"artworkUrl100": "https://is2-ssl.mzstatic.com/image/thumb/Music118/v4/73/24/2c/73242c65-1b6f-0dce-9740-fa84a92607e1/source/100x100bb.jpg",
		"collectionPrice": 0.00,
		"trackPrice": 0.00,
		"trackRentalPrice": 0,
		"collectionHdPrice": 0,
		"trackHdPrice": 0,
		"trackHdRentalPrice": 0,
		"releaseDate": "2018-11-26T15:47:00Z",
		"collectionExplicitness": "cleaned",
		"trackExplicitness": "cleaned",
		"trackCount": 7,
		"country": "USA",
		"currency": "USD",
		"primaryGenreName": "Technology",
		"contentAdvisoryRating": "Clean",
		"artworkUrl600": "https://is2-ssl.mzstatic.com/image/thumb/Music118/v4/73/24/2c/73242c65-1b6f-0dce-9740-fa84a92607e1/source/600x600bb.jpg",
		"genreIds": ["1318", "26"],
		"genres": ["Technology", "Podcasts"]
	}]
}
```

## HTTP Response Codes 

Servers send HTTP status codes to provide quick information on the response sent by the client.

- 1xx (Informational): Request recieved, continuing process
- 2xx (Successful): the action was successfully received, understood, and accepted
- 3xx ( Redirection): Further action needs to be taken in order to complete the request 
- 4xx (Client Error): The request contains bad syntax or cannot be fulfilled 
- 5xx (Server Error): The server failed to fulfill an apparently valid request

## Vocabulary 

- **URI:** a system for identifying pieces of information on the network. [URI](https://en.wikipedia.org/wiki/Uniform_Resource_Identifier)
- **HTTP Methods:** the protocol currently contains 8 methods for requesting a URI: OPTIONS, GET, HEAD, POST, PUT, DELETE, TRACE, CONNECT. 
- **HTTP Headers:** the headers are additional data sent by the user again to give more context about the transaction going on between the client and the server. Some of them will help the server reply in the most appropriate way.
