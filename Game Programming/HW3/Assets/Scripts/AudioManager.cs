using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.Audio;

public class AudioManager : MonoBehaviour
{
    public Sound[] sounds;
    void Awake()
    {
        foreach(Sound s in sounds)
        {
            s.source = gameObject.AddComponent<AudioSource>();
            s.source.clip = s.clip;
            s.source.volume = s.volume;
            s.source.pitch = s.pitch;
        }
    }

    public void Play(string name)
    {
        print("PLay");
//		Sound snd = Array.Find(sounds, sound => sound.name == name);
//		snd.source.Play();
        foreach(Sound s in sounds)
        {
            if(s.name == name)
            {
                print("Sound " + s.name);
                s.source.Play();
            }
        }
    }


}