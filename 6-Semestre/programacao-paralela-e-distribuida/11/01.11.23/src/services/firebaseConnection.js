// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import {getFirestore} from 'firebase/firestore'
import {getAuth} from 'firebase/auth'


const firebaseConfig = {
  apiKey: "AIzaSyC8M0bZj49YuqwDtOSXLIdtGaN0X6nDFfE",
  authDomain: "devlinks-72f5e.firebaseapp.com",
  projectId: "devlinks-72f5e",
  storageBucket: "devlinks-72f5e.appspot.com",
  messagingSenderId: "622944271432",
  appId: "1:622944271432:web:6dcee2c8609d83d8e1ac7d",
  measurementId: "G-GRXQYZ7F4P"
};

const firebaseApp = initializeApp(firebaseConfig);

const db = getFirestore(firebaseApp);

const auth = getAuth(firebaseApp);

export { db, auth};