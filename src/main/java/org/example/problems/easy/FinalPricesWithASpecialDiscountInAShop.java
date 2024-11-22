package org.example.problems.easy;

/**
 * 1475. Final Prices With a Special Discount in a Shop
 * You are given an integer array prices where prices[i] is the price of the ith item in a shop.
 * <p>
 * There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you will not receive any discount at all.
 * <p>
 * Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [8,4,6,2,3]
 * Output: [4,2,4,2,3]
 * Explanation:
 * For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4.
 * For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2.
 * For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4.
 * For items 3 and 4 you will not receive any discount at all.
 * Example 2:
 * <p>
 * Input: prices = [1,2,3,4,5]
 * Output: [1,2,3,4,5]
 * Explanation: In this case, for all items, you will not receive any discount at all.
 * Example 3:
 * <p>
 * Input: prices = [10,1,1,6]
 * Output: [9,0,1,6]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= prices.length <= 500
 * 1 <= prices[i] <= 1000
 */
public class FinalPricesWithASpecialDiscountInAShop {

    public static int[] finalPricesWithASpecialDiscountInAShop_0ms(int[] prices) {
        int j, i;
        for (i = 0; i < prices.length; i++) {
            for (j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        return prices;
    }
}
