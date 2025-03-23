using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AnimateArrow : MonoBehaviour
{
    private Animator arrowAnimator;
    private Rigidbody2D rigidbody;
    private GameObject arrow;

    // Start is called before the first frame update
    void Start()
    {
        arrowAnimator = GetComponent<Animator>();
        rigidbody = GetComponent<Rigidbody2D>();
        arrow = GameObject.Find("Arrow");

    }

    // Update is called once per frame

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.CompareTag("MazeWall"))
        {
            arrowAnimator.Play("Impact");
        }
        else
        {
            arrowAnimator.Play("Flight");
        }
    }
}