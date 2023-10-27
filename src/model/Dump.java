
package model;

public class Dump {
    private int totalGarbage;
    private float time;
    private int costPaidToDump;

    public Dump() {
    }

    public Dump(int totalGarbage, float time) {
        this.totalGarbage = totalGarbage;
        this.time = time;
        this.costPaidToDump = 0;
    }

    public int getTotalGarbage() {
        return totalGarbage;
    }

    public void setTotalGarbage(int totalGarbage) {
        this.totalGarbage = totalGarbage;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public int getCostPaidToDump() {
        return costPaidToDump;
    }

    public void setCostPaidToDump(int costPaidToDump) {
        this.costPaidToDump = costPaidToDump;
    }
    
}
