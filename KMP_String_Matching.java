class KMP_String_Matching {
  static int iteracoes;
  static int instrucoes;

  public static void main(String[] args) {
    String s1 = "ABCDCBDCBDACBDABDCBADF";
    // String s1 =
    String s2 = "ADF";

    KMPSearch(s2, s1);
    System.out.printf("Iteracoes: %d\nInstrucoes: %d",iteracoes,instrucoes);
  }

  static int KMPSearch(String pat, String txt) {
    int M = pat.length(); // tamanho padrao
    instrucoes += 2;
    int N = txt.length(); // tamanho texto
    instrucoes += 2;

    // cria lps[] que vai guardar o maior
    // valor prefixo sufixo para o padrão
    int lps[] = new int[M];
    instrucoes += 2;
    int j = 0; // index for pat[]
    instrucoes += 2;

    // Calcula lps[]
    computeLPSArray(pat, M, lps);
    instrucoes++;

    int i = 0; // index for txt[]
    while (i < N) {
      iteracoes++;
      instrucoes++;
      if (pat.charAt(j) == txt.charAt(i)) {
        j++;
        i++;
        instrucoes += 2;
      }
      instrucoes += 3; // if acima
      if (j == M) {
        System.out.println("Found pattern " + "at index " + (i - j));
        j = lps[j - 1];
        instrucoes += 8; // if + operacoes
      }
      // mismatch após j matches
      else if (i < N && pat.charAt(j) != txt.charAt(i)) {
        // Não faz match dos caracteres lps[0..lps[j-1]],
        // não é necesssário, eles combinarão
        if (j != 0)
          j = lps[j - 1];
        else
          i = i + 1;

        instrucoes += 3;
      }
    }
    instrucoes++;
    return j;
  }

  static void computeLPSArray(String pat, int M, int lps[]) {
    // tamanho do maior prefixo sufixo anterior
    int len = 0;
    int i = 1;
    lps[0] = 0; // lps[0] is always 0

    instrucoes+=3;

    // loop calcula lps[i] for i = 1 to M-1
    while (i < M) {
      iteracoes++;
      instrucoes+=3;
      if (pat.charAt(i) == pat.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
        instrucoes+=4;
      } else // (pat[i] != pat[len])
      {
        if (len != 0) {
          len = lps[len - 1];
          instrucoes+=2;
        } else // if (len == 0)
        {
          lps[i] = len;
          i++;
          instrucoes+=3;
        }
        instrucoes++;
      }
    }
  }
}