package br.senai.sp.informatica.servlets.libs;

import lombok.Data;

@Data
public class Mensagem {
  private String titulo = "";
  private String texto = "";
  private String url = "";
}