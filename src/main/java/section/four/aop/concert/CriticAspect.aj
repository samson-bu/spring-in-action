package section.four.aop.concert;

public aspect CriticAspect {
    public CriticAspect() {}

    pointcut performance() : execution(* perform(..));


    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
