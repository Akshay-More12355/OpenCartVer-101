//package utilities;
//
//
//
//import java.util.Properties;
//import javax.mail.*;
//import javax.mail.internet.*;
//
//public class EmaiReport {
//	public static void sendEmail(String to, String subject, String body, String attachmentPath) {
//		final String from = "kumarvikasg786@gmail.com";  // Sender's email
//		final String password = "pfif ygfi gqia ttxn"; // Sender's email password
//
//		// Set up properties for the mail session
//		Properties properties = new Properties();
//		properties.put("mail.smtp.auth", "true");
//		properties.put("mail.smtp.starttls.enable", "true");
//		properties.put("mail.smtp.host", "smtp.gmail.com");
//		properties.put("mail.smtp.port", "587");
//
//		// Authenticate and create session
//		Session session = Session.getInstance(properties, new Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(from, password);
//			}
//		});
//
//		try {
//			// Create email message
//			MimeMessage message = new MimeMessage(session);
//			message.setFrom(new InternetAddress(from));
//			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//			message.setSubject(subject);
//
//			// Email body
//			MimeBodyPart messageBodyPart = new MimeBodyPart();
//			messageBodyPart.setText(body);
//
//			// Attach file
//			Multipart multipart = new MimeMultipart();
//			multipart.addBodyPart(messageBodyPart);
//			if (attachmentPath != null && !attachmentPath.isEmpty()) {
//				MimeBodyPart attachmentPart = new MimeBodyPart();
//				attachmentPart.attachFile(attachmentPath);
//				multipart.addBodyPart(attachmentPart);
//			}
//
//			// Set content
//			message.setContent(multipart);
//
//			// Send email
//			Transport.send(message);
//			System.out.println("Email sent successfully!");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
//
//
//
