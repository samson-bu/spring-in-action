package section.four.aop.concert;

public class SamplePerformance implements Performance {
    @Override
    public void perform() {
        System.out.println("Performance start");
        System.out.println("performance end");
    }
}
