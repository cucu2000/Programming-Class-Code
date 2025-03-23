using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class GameController : MonoBehaviour
{

    [SerializeField] private float timeRemaining;
    [SerializeField] private Text timeCounter;
    [SerializeField] private Text scoreText;
    private int score;
    
    // Update is called once per frame
    void Update()
    {
        countDown();
    }

    void countDown()
    {

        if (timeRemaining > 0)
        {
            timeRemaining -= Time.deltaTime;
            timeCounter.text = timeRemaining.ToString();
        }
    }
    
    public void IncreaseScore(int reward) {
        score += reward;
        timeRemaining += 10;
        scoreText.text = score.ToString();
    }
}
