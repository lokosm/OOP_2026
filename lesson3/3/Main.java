package Lesson3.n4;


import java.time.LocalDate;

class Document {
    private String number;
    private String title;
    private String author;
    private String organization;
    private String content;
    private String date;
    private String formattedDocument;

    public void setNumber(String number) {
        this.number = number;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFormattedDocument(String formattedDocument) {
        this.formattedDocument = formattedDocument;
    }

    public String getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getOrganization() {
        return organization;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public String getFormattedDocument() {
        return formattedDocument;
    }
}

// Класс формирования номера документа
class DocumentNumbering {
    private int nextNumber;
    private String prefix;
    private int numberLength;

    public DocumentNumbering() {
        nextNumber = 1;
        prefix = "DOC";
        numberLength = 4;
    }

    public String generateNumber() {
        String number = String.format("%0" + numberLength + "d", nextNumber);
        nextNumber++;
        return prefix + "-" + number;
    }

    public int getNextNumber() {
        return nextNumber;
    }

    public void resetNumbering() {
        nextNumber = 1;
    }
}

// Класс формирования содержимого
class DocumentContent {
    private String title;
    private String text;
    private String additionalText;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addText(String additionalText) {
        this.additionalText = additionalText;
    }

    public String createContent() {
        return text + additionalText;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}

// Класс оформления документа
class DocumentFormatting {
    private String header;
    private String separator;
    private String footer;

    public DocumentFormatting() {
        header = "ДОКУМЕНТ";
        separator = "------------------------------";
        footer = "КОНЕЦ ДОКУМЕНТА";
    }

    public String formatDocument(Document document) {
        return header + "\n" +
                "Номер: " + document.getNumber() + "\n" +
                "Название: " + document.getTitle() + "\n" +
                separator + "\n" +
                "Автор: " + document.getAuthor() + "\n" +
                "Организация: " + document.getOrganization() + "\n" +
                "Дата: " + document.getDate() + "\n" +
                separator + "\n" +
                document.getContent() + "\n" +
                footer;
    }

    public void changeHeader(String header) {
        this.header = header;
    }

    public void changeFooter(String footer) {
        this.footer = footer;
    }
}

// Класс добавления информации о документе
class DocumentMetadata {
    private String author;
    private String organization;
    private String date;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setCurrentDate() {
        date = LocalDate.now().toString();
    }

    public String getAuthor() {
        return author;
    }

    public String getOrganization() {
        return organization;
    }

    public String getDate() {
        return date;
    }
}

// Класс проверки документа
class DocumentValidation {
    private boolean valid;
    private String errorMessage;
    private int checkedFields;

    public boolean validate(Document document) {
        valid = true;
        errorMessage = "";
        checkedFields = 0;

        if (document.getTitle() == null ||
                document.getTitle().trim().isEmpty()) {
            valid = false;
            errorMessage += "Не указано название документа.\n";
        }
        checkedFields++;

        if (document.getAuthor() == null ||
                document.getAuthor().trim().isEmpty()) {
            valid = false;
            errorMessage += "Не указан автор документа.\n";
        }
        checkedFields++;

        if (document.getContent() == null ||
                document.getContent().trim().isEmpty()) {
            valid = false;
            errorMessage += "Отсутствует содержимое документа.\n";
        }
        checkedFields++;

        return valid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getCheckedFields() {
        return checkedFields;
    }
}

// Главный класс-фасад
class DocumentFacade {
    private DocumentNumbering numbering;
    private DocumentContent content;
    private DocumentFormatting formatting;
    private DocumentMetadata metadata;
    private DocumentValidation validation;

    public DocumentFacade() {
        numbering = new DocumentNumbering();
        content = new DocumentContent();
        formatting = new DocumentFormatting();
        metadata = new DocumentMetadata();
        validation = new DocumentValidation();
    }

    public void createDocument(String title, String author,
            String organization, String text) {

        Document document = new Document();

        // Формирование номера
        document.setNumber(numbering.generateNumber());

        // Заполнение содержимого
        content.setTitle(title);
        content.setText(text);
        content.addText("");

        document.setTitle(content.getTitle());
        document.setContent(content.createContent());

        // Добавление информации
        metadata.setAuthor(author);
        metadata.setOrganization(organization);
        metadata.setCurrentDate();

        document.setAuthor(metadata.getAuthor());
        document.setOrganization(metadata.getOrganization());
        document.setDate(metadata.getDate());

        // Проверка документа
        if (!validation.validate(document)) {
            System.out.println("Ошибка создания документа:");
            System.out.println(validation.getErrorMessage());
            return;
        }

        // Оформление документа
        document.setFormattedDocument(
                formatting.formatDocument(document));

        System.out.println("Документ успешно создан!");
        System.out.println();
        System.out.println(document.getFormattedDocument());
    }

    public void setDocumentHeader(String header) {
        formatting.changeHeader(header);
    }

    public void setDocumentFooter(String footer) {
        formatting.changeFooter(footer);
    }

    public void resetNumbering() {
        numbering.resetNumbering();
    }
}

// Главный класс программы
public class Main {
    public static void main(String[] args) {

        DocumentFacade document = new DocumentFacade();

        document.createDocument(
                "Заявление",
                "Иванов Иван",
                "Учебное заведение",
                "Прошу предоставить мне справку об обучении."
        );

        System.out.println();

        document.createDocument(
                "Отчёт",
                "Петров Пётр",
                "Учебное заведение",
                "Отчёт о выполненной работе."
        );
    }
}

