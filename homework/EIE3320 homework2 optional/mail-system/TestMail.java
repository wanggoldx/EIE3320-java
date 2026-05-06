public class TestMail
{
 public static void main(String [] args) {
 MailServer ms = new MailServer(); // Line A
 MailClient mc1 = new MailClient(ms, "Peter");
 MailClient mc2 = new MailClient(ms, "Paul");
 mc1.sendMessage("Paul","Hello, I am Peter");
 mc2.sendMessage("Peter","Hello, I am Paul");
 }
}
