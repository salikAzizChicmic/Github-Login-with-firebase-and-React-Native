import React, { useEffect, useState } from 'react'
import { NativeModules, Text, TouchableOpacity, View } from 'react-native'

const App = () => {
  const [email,setEmail]=useState("No user found")
  var openActivity=NativeModules.OpenActivity
  const handleClick=()=>{
    openActivity.open((value)=>{
      openActivity.getEmail((value1)=>{
        setEmail(value1)
      })
    })
  }

  
  return (
    <View style={{flexDirection:'column',justifyContent:'center',alignItems:'center',marginTop:200}} >
      <Text style={{fontSize:20,fontWeight:'bold'}}>{email}</Text>
      <TouchableOpacity onPress={handleClick} style={{backgroundColor:'#0072b1',marginTop:20,borderRadius:10}}>
        <Text style={{color:'white',fontSize:20,fontWeight:'bold',paddingHorizontal:20,paddingVertical:10}}>Auth</Text>
      </TouchableOpacity>
    </View>
  )
}

export default App