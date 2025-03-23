using System;
using System.Security.Cryptography;
using UnityEditor.SearchService;
using UnityEngine;
using UnityEngine.UI;

public class Coin : MonoBehaviour
{
    
    [SerializeField] private float speed;
    private GameObject gameController;
    [SerializeField] private int basicScore;
    Vector3 screenHeight;
    private float currentScreenHeight;
    
    
    // Use this for initialization
    void Start () {
        screenHeight = Camera.main.ScreenToWorldPoint(new Vector3(0, Screen.height));
         currentScreenHeight = screenHeight.y;
         gameController = GameObject.FindWithTag("GameController");
    }
	
    // Update is called once per frame
    void Update () {
        transform.Translate(-Vector3.up * Time.deltaTime * speed);
    }
    
    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.CompareTag("Player")) {
            print(collision.gameObject);
            FindObjectOfType<AudioManager>().Play("Coin");
            gameController.GetComponent<GameController>().IncreaseScore(basicScore);
            Destroy(this.gameObject);
        }else if (collision.gameObject.CompareTag("Ground"))
        {
            print(collision.gameObject);
            gameController.GetComponent<GameController>().endGame();
            Destroy(this.gameObject);
        }
    }
}