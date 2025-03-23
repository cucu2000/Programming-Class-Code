using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Point : MonoBehaviour
{
    private GameController gameController;
    [SerializeField] private int score;

    // Start is called before the first frame update
    void Start()
    {
        gameController = GameObject.FindObjectOfType<GameController>();
    }

    private void OnCollisionEnter(Collision collision)
    {
        if (collision.gameObject.CompareTag("Player"))
        {
            print(collision.gameObject);
            gameController.GetComponent<GameController>().IncreaseScore(score);
            Destroy(this.gameObject);
        }
    }
}
