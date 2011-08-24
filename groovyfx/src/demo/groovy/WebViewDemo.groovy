/*
* Copyright 2011 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License")
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/



import groovyx.javafx.GroovyFX
import groovyx.javafx.SceneGraphBuilder

def url = "http://www.yahoo.com"

GroovyFX.start {
    def sg = new SceneGraphBuilder()

    def webEngine = sg.webEngine(location: url)
    def goAction = { webEngine.load(urlField.getText()) }

    sg.stage(title: "GroovyFX WebView Demo", visible: true) {
        scene(fill: groovyblue, width: 640, height: 500) {
            vbox() {
                hbox(padding: 10, spacing: 5) {
                    urlField = textField(text: url, onAction: goAction, prefWidth:400)
                    button("Go", onAction: goAction)
                }
                wv = webView(engine: webEngine)
            }
        }
    }
}


