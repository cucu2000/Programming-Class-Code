using System;
using System.Collections;
using System.Collections.Generic;
using System.Security.Cryptography;
using UnityEngine;
using UnityEngine.UI;
using Random = UnityEngine.Random;

public class GameController : MonoBehaviour
{
    [SerializeField] private GameObject coin;
    public Text scoreRef;
    public Text highScoreRef;
    [SerializeField] private float spawnTime;
    [SerializeField] private float spawnDelay;
    [SerializeField] private GameObject canvasMain;
    [SerializeField] private GameObject canvasHighScore;
    private static int highScore = 0;
    Vector3 screenToWorldPos;
    int screenWidth;
    int screenHeight;
    int score = 0;
    private GameObject playerSpawn;
    [SerializeField] private GameObject player;
    
    // Start is called before the first frame update
    void Start()
    {
        playerSpawn = GameObject.FindWithTag("Spawn");
        InvokeRepeating("spawnCoin", spawnTime, spawnDelay);
    }

    public void spawnCoin()
    {
        Instantiate(coin, RandomPosition(), transform.rotation);
    }
    
    Vector3 RandomPosition() {
        screenWidth = Screen.width;
        screenHeight = Screen.height;
        screenToWorldPos = Camera.main.ScreenToWorldPoint(new Vector3(Random.Range(0, screenWidth), screenHeight, 1));
        return screenToWorldPos;
    }

    public void IncreaseScore(int reward) {
        score += reward;
        scoreRef.text = "Score: " + score.ToString();

        if (score == 5 || score == 7 || score == 9 || score == 10)
        {
            spawnDelay -= 1;
            spawnTime -= 1;
            CancelInvoke();
            InvokeRepeating("spawnCoin", spawnTime, spawnDelay);
        }
    }
    
    public void endGame()
    {
        CancelInvoke();
        var spawnedCoins = GameObject.FindGameObjectsWithTag("Coin");
        foreach (var spawnedCoin in spawnedCoins)
        {
            Destroy(spawnedCoin);
        }
        canvasMain.SetActive(false);
        canvasHighScore.SetActive(true);
        if (score > highScore)
        {
            highScore = score;
            highScoreRef.text = "HighScore: " + highScore.ToString();
        }
    }

    public void Restart()
    {
        score = default;
        spawnTime = 5;
        spawnDelay = 5;
        scoreRef.text = "Score: " + score;
        canvasHighScore.SetActive(false);
        canvasMain.SetActive(true);
        player.GetComponent<Rigidbody2D>().position = new Vector2(playerSpawn.transform.position.x, playerSpawn.transform.position.y);
        InvokeRepeating("spawnCoin", spawnTime, spawnDelay);
    }

    public void exitGame()
    {
        Application.Quit();
    }
}
