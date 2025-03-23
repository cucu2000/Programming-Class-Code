public class Proxy implements ProxyInterface{

    ProxyInterface pr;

    @Override
    public Float numDbl(Float num) {
        pr = new mathTwo();
        return pr.numDbl(num);
    }
}
