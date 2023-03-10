package club.calong.tipper.exception;

public class TipperParseException extends RuntimeException {

    private Integer lineNumber;

    private Integer code;

    private String message;

    public TipperParseException(String message, Integer lineNumber, Integer code, String message1) {
        super(message);
        this.lineNumber = lineNumber;
        this.code = code;
        this.message = message1;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
