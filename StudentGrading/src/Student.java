import Exception_handle.InvalidInputException;

class Student extends Person {
    private double maths;
    private double science;
    private double english;

    public Student(String name) {
        super(name);
    }

    public void setMaths(double maths) throws InvalidInputException {
        if (maths < 0 || maths > 100)
            throw new InvalidInputException("Maths grade must be between 0 and 100.");
        this.maths = maths;
    }

    public void setScience(double science) throws InvalidInputException {
        if (science < 0 || science > 100)
            throw new InvalidInputException("Science grade must be between 0 and 100.");
        this.science = science;
    }

    public void setEnglish(double english) throws InvalidInputException {
        if (english < 0 || english > 100)
            throw new InvalidInputException("English grade must be between 0 and 100.");
        this.english = english;
    }

    public double calculateAverage() {
        return (maths + science + english) / 3;
    }

    @Override
    public String toString() {
        return String.format(
            "%-10s | Maths: %.1f | Science: %.1f | English: %.1f | Avg: %.2f",
            name, maths, science, english, calculateAverage()
        );
    }
}