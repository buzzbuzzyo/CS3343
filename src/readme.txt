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

3. Remove product: 'removeProduct productID'
remove 10000

4. fill product: 'fill productID quantity'
fill 10000 300

5. show sale records 'showSaleRecord'
showSaleRecord
