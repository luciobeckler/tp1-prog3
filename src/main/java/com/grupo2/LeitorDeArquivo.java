package com.grupo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeitorDeArquivo {

  private static List<String> linhaArray;

  public static void leArquivoEgeraListaDeVideos(String caminhoData) {

    try {
      BufferedReader buffer = new BufferedReader(new FileReader(caminhoData));
      String linha = buffer.readLine();
      while ((linha = buffer.readLine()) != null) {
        Video.addVideoEmListaVideos(criaObjetosVideo(linha));
      }
      buffer.close();
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  private static boolean isVerifiedStatusTrue(String valor) {
    return (valor.equals("verified") || valor.equals("not verified"));
  }

  private static Video criaObjetosVideo(String linha) {
    linhaArray = new ArrayList<>(Arrays.asList(linha.split(",")));

    linhaArray.remove(0);

    while (!isVerifiedStatusTrue(linhaArray.get(4))) {
      if (linhaArray.size() > 5) {
        linhaArray.set(4, linhaArray.get(4) + ", " + linhaArray.get(5));
        linhaArray.remove(4);
      }
    }
    return new Video(
        linhaArray.get(0),
        Long.parseLong(linhaArray.get(1)),
        Integer.parseInt(linhaArray.get(2)),
        linhaArray.get(3),
        linhaArray.get(4),
        linhaArray.get(5),
        Integer.parseInt(linhaArray.get(6)),
        Integer.parseInt(linhaArray.get(7)),
        Integer.parseInt(linhaArray.get(8)),
        Integer.parseInt(linhaArray.get(9)),
        Integer.parseInt(linhaArray.get(10)));
  }
}
