/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.coincharge;

/**
 *
 * @author Windows 10 Pro
 */
//Explain: Enum with fields and a constructor to attach intrinsic values to each constant
enum Coin {
    QUARTER(25), DIME(10), NICKEL(5), PENNY(1);

    final int value;

    Coin(int value) {
        this.value = value;
    }
}

public class CoinCharge {

    public static void main(String[] args) {
        int amount = 87;

        //Explain: Iterating through coin values in descending order to calculate the fewest coins required (greedy approach)
        for (Coin coin : Coin.values()) {
            int count = amount / coin.value;
            if (count > 0) {
                System.out.println(coin + ": " + count);
                amount %= coin.value;
            }
        }
    }
}
