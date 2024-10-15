import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("result")
    private String resultado;

    @SerializedName("rates")
    private Rates rates;

    public Response() {
    }


    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }
}
