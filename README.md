# Javafrysk/J

Javafrysk/J (Jafy/J) is in oersetter dy't programmakoade oerset fan Javafrysk nei standert Java. Mei Jafy/J kin dus Javafrysk draait wurde op kompjûters dy't sels gjin ferstân hawwe fan Javafrysk.

Javafrysk/J (Jafy/J) is a compiler that translates Javafrysk into standard Java. Using Jafy/J, programs written in Javafrysk can be ported to other machines more easily, including machines that do not support Javafrysk natively.

Javafrysk/J (Jafy/J) is een vertaler die programmacode omzet van Javafrysk naar standaard Java. Met Jafy/J kunnen dus programma's geschreven in Javafrysk eenvoudiger gereed worden gemaakt voor andere computers, zelfs als die computers geen Javafrysk ondersteunen.

````
$ cat foarbielden/GruttePier.jafy
klasse GruttePier {
    GruttePier() {
    }

    boolsk ûnderfreegje(Brûker bruker) goait FeiligensUtsûnderingsgefal {
        Brea brea = nij Brea("Roggebrea");

        as (brea.hat("bûter") && tsiis.isGrien()) {
            smytop wier;
        } oars {
            goai nij FeiligensUtsûnderingsgefal("Gjin oprjochte arguminten.");
        }
    }

    statysk neat main(Tried[] arguminten) {
        Brûker brûker = nul;
        GruttePier pier = nije GruttePier();

        besykje {
            pier.ûnderfreegje(brûker);
        } fang (FeiligensUtsûnderingsgefal ug) {
            ug.printsjeStapelTrochslach();
        }
    }
}
$ java -jar jafy.jar foarbielden/GruttePier.jafy
class GruttePier {
    GruttePier() {
    }

    boolean ûnderfreegje(Brûker bruker) throws SecurityException {
        Brea brea = new Brea("Roggebrea");

        if (brea.hat("bûter") && tsiis.isGrien()) {
            return true;
        } else {
            throw new SecurityException("Gjin oprjochte arguminten.");
        }
    }

    static void main(String[] arguminten) {
        Brûker brûker = null;
        GruttePier pier = new GruttePier();

        try {
            pier.ûnderfreegje(brûker);
        } catch (SecurityException ug) {
            ug.printStackTrace();
        }
    }
}
````
