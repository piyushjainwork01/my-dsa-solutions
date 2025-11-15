public class Main {
    public static void main(String[] args) {
        System.out.println("Setup successful!");

        // Test template import
        templates.prefixsum.PrefixSumCount template =
                new templates.prefixsum.PrefixSumCount();

        int[] nums = {1, 1, 1};
        int result = template.subarraySum(nums, 2);
        System.out.println("Result: " + result);  // Should print 2
    }
}
