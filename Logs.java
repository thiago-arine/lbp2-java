interface Logger {
    void log(String msg);
}

class ConsoleLogger implements Logger {
    @Override
    public void log(String msg) {
        System.out.println("LOG CONSOLE: " + msg);
    }
}

class FileLogger implements Logger {
    @Override
    public void log(String msg) {
        System.out.println("LOG ARQUIVO: " + msg);
    }
}

class LoggerFactory {
    public static Logger criarLogger(String tipo) {
        if (tipo.equalsIgnoreCase("console")) {
            return new ConsoleLogger();
        } else if (tipo.equalsIgnoreCase("arquivo")) {
            return new FileLogger();
        }
        throw new IllegalArgumentException("Tipo de log desconhecido");
    }
}

public class Logs {
    public static void main(String[] args) {
        
        Logger log1 = LoggerFactory.criarLogger("console");
        log1.log("Sistema iniciado com sucesso.");
      
        Logger log2 = LoggerFactory.criarLogger("arquivo");
        log2.log("Gravando...");
    }
}