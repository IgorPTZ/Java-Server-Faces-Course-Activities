package br.com.devdojo.maratonajsf.bean.upload;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;

@Named
@ViewScoped
public class UploadTesteBean implements Serializable {

    private Part arquivo;

    public void upload() {

        if(arquivo == null) {
            return;
        }

        try (InputStream inputStream = arquivo.getInputStream()) {
            String nomeArquivo = arquivo.getSubmittedFileName();

            System.out.println(nomeArquivo);
            System.out.println(arquivo.getName());
            System.out.println(arquivo.getSize());
            System.out.println(arquivo.getContentType());
            System.out.println(arquivo.getHeaderNames());

            Files.copy(inputStream,
                    new File("C:\\Users\\Igor\\IdeaProjects\\maratona-jsf",
                              nomeArquivo).toPath());

            FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO,
                                            "Arquivo enviado com sucesso!",
                                               "");

            FacesContext.getCurrentInstance().addMessage(null, mensagem);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public Part getArquivo() {
        return arquivo;
    }

    public void setArquivo(Part arquivo) {
        this.arquivo = arquivo;
    }
}
