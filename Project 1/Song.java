// Anastasia Erofeeva
// 03/31/2016
// CSE 142
// TA: Rajneil Rana
// Assignment #1
// 
// This program will print a cumulative song as output. 

public class Song {
   public static void main(String[] args) {
      fly();
      spider();
      bird();
      cat();
      dog();
      pig();
      horse();
   }
   
   public static void fly() {
      System.out.println("There was an old woman who swallowed a fly.");
      whyFly();
   }
   
   public static void spider() {
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      whySpider();
   }
   
   public static void bird() {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      whyBird();
   }
   
   public static void cat() {
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      whyCat();
   }
   
   public static void dog() {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      whyDog();
   }
   
   public static void pig() {
      System.out.println("There was an old woman who swallowed a pig,");
      System.out.println("She must have been big to swallow a pig.");
      whyPig();
   }
   
   public static void horse() {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }
   
   public static void whyFly() {
      System.out.println("I don't know why she swallowed that fly,");
      perhaps();
      System.out.println();
   }
   
   public static void whySpider() {
      System.out.println("She swallowed the spider to catch the fly,");
      whyFly();
   }
   
   public static void whyBird() {
      System.out.println("She swallowed the bird to catch the spider,");
      whySpider();
   }
   
   public static void whyCat() {
      System.out.println("She swallowed the cat to catch the bird,");
      whyBird();
   }
   
   public static void whyDog() {
      System.out.println("She swallowed the dog to catch the cat,");
      whyCat();
   }
   
   public static void whyPig() {
      System.out.println("She swallowed the pig to catch the dog,");
      whyDog();
   }
   
   public static void perhaps() {
      System.out.println("Perhaps she'll die.");
   }
}