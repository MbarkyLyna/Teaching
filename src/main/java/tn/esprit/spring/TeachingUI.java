package tn.esprit.spring;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;
@XmlRootElement
public class TeachingUI {
    private int code;
    private String domain;
    private String head;
    private int credits;
    private int semester;

    public TeachingUI() {
    }

    public TeachingUI(int code, String domain, String head, int credits, int semester) {
        this.code = code;
        this.domain = domain;
        this.head = head;
        this.credits = credits;
        this.semester = semester;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getSemester() {
        return semester;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TeachingUI that)) return false;
        return code == that.code && credits == that.credits && semester == that.semester && Objects.equals(domain, that.domain) && Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, domain, head, credits, semester);
    }

    public void setSemester(int semester) {
        this.semester = semester;

    }

    @Override
    public String toString() {
        return "TeachingUI{" +
                "code=" + code +
                ", domain='" + domain + '\'' +
                ", head='" + head + '\'' +
                ", credits=" + credits +
                ", semester=" + semester +
                '}';
    }
}
