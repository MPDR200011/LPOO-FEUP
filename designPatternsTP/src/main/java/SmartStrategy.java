public class SmartStrategy implements OrderingStrategy {

    private boolean pending;
    private StringRecipe recipe;

    public SmartStrategy() {
        this.pending = false;
    }

    @Override
    public void wants(StringRecipe recipe, StringBar bar) {
        if (bar.isHappyHour()) {
            bar.order(recipe);
        } else {
            pending = true;
            this.recipe =  recipe;
        }
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        if (pending) {
            bar.order(recipe);
            pending = false;
        }
    }

    @Override
    public void happyHourEnded(StringBar bar) {
        return;
    }
}
