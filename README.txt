	Today, encryption and decryption algorithms are used everywhere on the Internet to protect our data. 
This is especially important for sites that handle sensitive data, such as e-commerce sites that accept online 
card payments and login areas that require users to enter their credentials. To ensure data security, there are 
complex encryption algorithms behind the scenes.
	
	To check the programm you have to print commands through the standart inpunt:
		Example 1
				
		Input:
			java Main -mode enc -in file_name.txt -out protected.txt -key 5
				
	This command must get data from the file file_name.txt (you have to create file woth content you wish), 
encrypt the data with the key 5, create a file called protected.txt and write ciphertext to it.

		Example 2

		Input:
			java Main -mode enc -key 5 -data "Welcome to hyperskill!"
				
		Output:
			\jqhtrj%yt%m~ujwxpnqq&
					
		Example 3

		Input:
			java Main -key 5 -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec
				
		Output:
			Welcome to hyperskill!
