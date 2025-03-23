/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';

import {SafeAreaView, StyleSheet, Text,} from 'react-native';
import {Colors} from 'react-native/Libraries/NewAppScreen';
import useColorScheme from "react-native/Libraries/Utilities/useColorScheme";
import Navigation from "./src/Navigation";
import {useAuth0, Auth0Provider} from 'react-native-auth0';

const App = () => {
    const isDarkMode = useColorScheme() === 'dark';

    const backgroundStyle = {
        backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
    };

    return (
        <Auth0Provider domain={"dev-slhz5sqp.us.auth0.com"} clientId={"GLXgZy4zZc7BiKwuiXHaQMEl2SKhIpL6"}>
            <SafeAreaView style={styles.root}>
                <Navigation/>
            </SafeAreaView>
        </Auth0Provider>
    );
};

const styles = StyleSheet.create({
    root: {
        flex: 1,
        backgroundColor: '#F9FBFC'
    }
});

export default App;
