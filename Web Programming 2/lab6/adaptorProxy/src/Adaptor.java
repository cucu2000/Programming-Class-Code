public class Adaptor implements AdaptorInterface{



    @Override
    public Float twiceOf(Float num) {
        return  (float) mathOne.dblNum(num);
    }
}
