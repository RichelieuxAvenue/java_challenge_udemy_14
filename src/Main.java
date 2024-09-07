public class Main {
    /*
        Nombre de Jours dans un Mois

Écrivez une méthode appelée isLeapYear avec un paramètre de type int nommé year.
Le paramètre doit être supérieur ou égal à 1 et inférieur ou égal à 9999.
Si le paramètre n’est pas dans cette plage, retournez false.
Sinon, si l’année est dans la plage valide, calculez si l’année est une année bissextile et retournez true si elle l’est, sinon retournez false.
Une année est bissextile si elle est divisible par 4 mais pas par 100, ou si elle est divisible par 400.

Exemples d’entrée/sortie :

	•	isLeapYear(-1600); → devrait retourner false car le paramètre n’est pas dans la plage (1-9999).
	•	isLeapYear(1600); → devrait retourner true car 1600 est une année bissextile.
	•	isLeapYear(2017); → devrait retourner false car 2017 n’est pas une année bissextile.
	•	isLeapYear(2000); → devrait retourner true car 2000 est une année bissextile.

REMARQUE : La solution de l’exercice sur les années bissextiles peut être réutilisée ici.

Méthode supplémentaire : getDaysInMonth

Écrivez une autre méthode appelée getDaysInMonth avec deux paramètres : month et year, tous deux de type int.

	•	Si le paramètre month est inférieur à 1 ou supérieur à 12, retournez -1.
	•	Si le paramètre year est inférieur à 1 ou supérieur à 9999, retournez -1.

Cette méthode doit retourner le nombre de jours dans le mois. Soyez attentif aux années bissextiles : elles ont 29 jours dans le mois 2 (février).

Vous devriez vérifier si l’année est une année bissextile en utilisant la méthode isLeapYear décrite ci-dessus.

Exemples d’entrée/sortie :

	•	getDaysInMonth(1, 2020); → devrait retourner 31 car janvier a 31 jours.
	•	getDaysInMonth(2, 2020); → devrait retourner 29 car février a 29 jours dans une année bissextile et 2020 est une année bissextile.
	•	getDaysInMonth(2, 2018); → devrait retourner 28 car février a 28 jours si ce n’est pas une année bissextile et 2018 n’est pas une année bissextile.
	•	getDaysInMonth(-1, 2020); → devrait retourner -1 car le paramètre month est invalide.
	•	getDaysInMonth(1, -2020); → devrait retourner -1 car le paramètre year est hors de la plage de 1 à 9999.

ASTUCE : Utilisez l’instruction switch.
REMARQUE : Les méthodes isLeapYear et getDaysInMonth doivent être définies comme public static, comme nous l’avons fait jusqu’à présent dans le cours.
REMARQUE : N’ajoutez pas de méthode main dans le code de la solution.
         */


    public static boolean isLeapYear(int year) {
        if (year<1 || year>9999) {
            return false;
        }
        return year%4==0 && year%100!=0 || year%400==0;
    }
    public static int getDaysInMonth(int month, int year) {
        boolean isLeapYear = isLeapYear(year);
        if (isLeapYear(year)) {//pour les années bissextiles
            return switch (month){
                case 1, 3, 5, 7, 8, 10, 12 -> {yield 31;}
                case 4, 6, 9, 11 -> {yield 30;}
                case 2 -> {yield 29;}
                default -> -1;
            };
        }
        else {//pour les années non bissextiles
            return switch (month){
                case 1, 3, 5, 7, 8, 10, 12 -> {yield 31;}
                case 4, 6, 9, 11 -> {yield 30;}
                case 2 -> {yield 28;}
                default -> -1;
            };
        }
    }

    public static void main(String[] args) {
        System.out.println(getDaysInMonth(2, 2020));

    }
}
