// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract BankAccount {
    // State variable to store each customer's balance
    mapping(address => uint) private balances;

    // Deposit event
    event Deposit(address indexed account, uint amount);

    // Withdrawal event
    event Withdrawal(address indexed account, uint amount);

    // Function to deposit money into the user's bank account
    function deposit() public payable {
        require(msg.value > 0, "Deposit amount must be greater than 0");
        balances[msg.sender] += msg.value;
        emit Deposit(msg.sender, msg.value);
    }

    // Function to withdraw money from the user's bank account
    function withdraw(uint amount) public {
        require(amount > 0, "Withdraw amount must be greater than 0");
        require(balances[msg.sender] >= amount, "Insufficient balance");

        balances[msg.sender] -= amount;
        payable(msg.sender).transfer(amount);
        emit Withdrawal(msg.sender, amount);
    }

    // Function to check the balance of the user's bank account
    function getBalance() public view returns (uint) {
        return balances[msg.sender];
    }
}
