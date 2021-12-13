public class SharedObject {

    private ThreadLocal<Integer> number = new ThreadLocal<>();

    public Integer getNumber() {
        return number.get();
    }

    public void setNumber(Integer number) {
        this.number.set(number);
    }
}
