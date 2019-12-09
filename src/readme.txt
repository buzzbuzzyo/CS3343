Readme
=================================================================
=================================================================
CityShopper
=================================================================
=================================================================


---------------------               Description                 ---------------------
This application is a trading platform for both customers and companies.

---------------------               Installation                 ---------------------
  1. Install the latest Java SE Runtime Environment 
        -You can get it from here - http://www.oracle.com/technetwork/java/javase/downloads/index.html
  2. Ensure you have setup the path for java
        -You can take a look of this if your environment have not setup - https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html

Windows
----
  3. Double Click the file ．cityShopper.bat・

Mac or Linux Environment
----  
  3. Open the terminal and input ．java -jar {file_path}/cityShopper.jar・

file_path = the location of the file


------------------------        Program Commands for Registration    --------------------
1. Register Company Account: 'register company userid password companyname'
regCompany cityu 1234 cityu 

2. Register Customer Account: 'register customer userid password name dateOfBirth firstDeposit' (dateOfBirth must be in format yyyy/mm/dd)
regCustomer tkleung 1234 Sam 2019/11/28 500

3. Login Account: 'login username password'
login tkleung 1234	

4. Logout the current Account 'logout'
logout
------------------------          For Customer Login Function        --------------------
1. Show all shop details: 
showAllShop

2. Show products of a specific shop details: 'show userid'
showShopProduct cityu

3. Add products of a shop to the shopping trolley: 'addToTrolley userId(shopId) pid quantity'
addToTrolley cityu 10000 10

4. Show shopping trolley item:
showTrolley

5. Remove shopping trolley item: 'removeFromTrolley pid quantity'
removeFromTrolley 10200 2

6. Deposit: 'deposit amount'
deposit 500

7. Checkout:
checkout

------------------------          For Company Login Function        --------------------
1. Add product: 'createProduct productName price stock'
createProduct apple 5 500

2. Show stock status: 
showStatus

3. Remove product: 'remove productID'
remove 10000

4. fill product: 'fill productID quantity'
fill 10000 300

5. show sale records 'showSaleRecord'
showSaleRecord


------------------------------              Credits                 -----------------
Project Manager: Leung Tsz Kin
Assistant Project Manager: Leung Ching Yin
Software Engineer: Sin Tak Yiu
Software Engineer: Wong Ho Ming

-------------------------------------        End             ---------------------------



