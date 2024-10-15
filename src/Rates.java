import com.google.gson.annotations.SerializedName;

public class Rates {

    @SerializedName("USD")
    private int usd;

    @SerializedName("ARS")
    private double parg;

    @SerializedName("BRL")
    private double rbr;

    @SerializedName("COP")
    private double pcol;


    public Rates() {
    }

    public int getUsd() {
        return usd;
    }

    public void setUsd(int usd) {
        this.usd = usd;
    }

    public double getParg() {
        return parg;
    }

    public void setParg(double parg) {
        this.parg = parg;
    }

    public double getRbr() {
        return rbr;
    }

    public void setRbr(double rbr) {
        this.rbr = rbr;
    }

    public double getPcol() {
        return pcol;
    }

    public void setPcol(double pcol) {
        this.pcol = pcol;
    }
}
