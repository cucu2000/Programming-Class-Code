using System;
using System.Collections;
using System.Collections.Generic;
using System.Net.Mime;
using UnityEngine;
using UnityEngine.UI;

public class HUD : MonoBehaviour
{
    public Text GemCount;
    public Text Collisions;

    private void Update()
    {
        GemCount.text = MainGame.getGems().ToString();
        Collisions.text = MainGame.getCollisions().ToString();
    }
}
