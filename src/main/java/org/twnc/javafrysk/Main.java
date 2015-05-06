package org.twnc.javafrysk;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.twnc.javafrysk.Javafrysk.*;

public class Main {
    private static final Integer[] TOKENS = {
            ABSTRACT, ASSERT, BOOLEAN, BREAK, BYTE, CASE,
            CATCH, CHAR, CLASS, CONST, CONTINUE, DEFAULT,
            DO, DOUBLE, ELSE, ENUM, EXTENDS, FALSE,
            FINAL, FINALLY, FLOAT, FOR, GOTO, IF,
            IMPLEMENTS, IMPORT, INSTANCEOF, INT, INTERFACE, LONG,
            NATIVE, NEW, NULL, PACKAGE, PRIVATE, PROTECTED,
            PUBLIC, RETURN, SHORT, STATIC, STRICTFP, SUPER,
            SWITCH, SYNCHRONIZED, THIS, THROW, THROWS, TRANSIENT,
            TRUE, TRY, VOID, VOLATILE, WHILE,
    };

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Usage/Besykje ris: java -jar jafy.jar <triem.jafy>");
        } else {
            ANTLRInputStream stream = new ANTLRFileStream(args[0]);
            Javafrysk lexer = new Javafrysk(stream);
            Vocabulary vocab = lexer.getVocabulary();
            Set<Integer> tokens = new HashSet<>();
            tokens.addAll(Arrays.asList(TOKENS));

            for (Token token : lexer.getAllTokens()) {
                int type = token.getType();
                String r = "";

                if (tokens.contains(type)) {
                    System.out.print(vocab.getSymbolicName(type).toLowerCase());
                } else if (type == IDENTIFIER) {
                    r = translate(token.getText());
                } else {
                    r = token.getText();
                }

                System.out.print(r);
            }
        }
    }

    private static String translate(String text) {
        switch (text) {
            case "Tried": return "String";

            case "RekkenkundigUtsûnderingsgefal":                  return "ArithmeticException";
            case "RijOantsjuttingBûtenGrinzenUtsûnderingsgefal":   return "ArrayIndexOutOfBoundsException";
            case "RijBewarjeUtsûnderingsgefal":                    return "ArrayStoreException";
            case "KlasseOmsetUtsûnderingsgefal":                   return "ClassCastException";
            case "YllegaalArgumintUtsûnderingsgefal":              return "IllegalArgumentException";
            case "YllegaleMonitorSteatUtsûnderingsgefal":          return "IllegalMonitorStateException";
            case "YllegaleSteatUtsûnderingsgefal":                 return "IllegalStateException";
            case "YllegaleProgrammaSteatUtsûnderingsgefal":        return "IllegalThreadStateException";
            case "OantsjuttingBûtenGrinzenUtsûnderingsgefal":      return "IndexOutOfBoundsException";
            case "NegatyfRijGrutteUtsûnderingsgefal":              return "NegativeArraySizeException";
            case "NulOanwizerUtsûnderingsgefal":                   return "NullPointerException";
            case "NûmerOpmaakUtsûnderingsgefal":                   return "NumberFormatException";
            case "FeiligensUtsûnderingsgefal":                     return "SecurityException";
            case "TriedOantsjuttingBûtenGrinzenUtsûnderingsgefal": return "StringIndexOutOfBoundsException";
            case "NetStipeOperaasjeUtsûnderingsgefal":             return "UnsupportedOperationException";
            case "KlasseNetFûnUtsûnderingsgefal":                  return "ClassNotFoundException";
            case "KloanNetStipeUtsûnderingsgefal":                 return "CloneNotSupportedException";
            case "YllegaleTagongUtsûnderingsgefal":                return "IllegalAccessException";
            case "EksimplaarUtsûnderingsgefal":                    return "InstantiationException";
            case "ÛnderbrutsenUtsûnderingsgefal":                  return "InterruptedException";
            case "GjinFjildMeiDyNammeUtsûnderingsgefal":           return "NoSuchFieldException";
            case "GjinMetoadeMeiDyNammeUtsûnderingsgefal":         return "NoSuchMethodException";

            case "printsjeStapelTrochslach": return "printStackTrace";

            default: return text;
        }
    }
}
