using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class MainGame : MonoBehaviour
{
   private static int gemCount = 0;
   private static int wallCollisions = 0;


   public static int getGems()
   {
      print("Get Gems");
      return gemCount;
   }
   
   public static void addItem()
   {
      print("Add Item");
      gemCount++;
   }

   public static int getCollisions()
   {
      return wallCollisions;
   }

   public static void setCollisions()
   {
      wallCollisions++;
   }
}
