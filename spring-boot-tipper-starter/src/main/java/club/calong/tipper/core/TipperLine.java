package club.calong.tipper.core;

public class TipperLine {

    private TipperLineType type;

    private Integer line;

    private String content;

    public TipperLineType getType() {
        return type;
    }

    public void setType(TipperLineType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public TipperLine(TipperLineType type, Integer line, String content) {
        this.type = type;
        this.line = line;
        this.content = content;
    }

    @Override
    public String toString() {
        return "TipperLine{" +
                "type=" + type +
                ", line=" + line +
                ", content='" + content + '\'' +
                '}';
    }
}
