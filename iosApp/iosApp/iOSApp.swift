import SwiftUI
import app

@main
struct iOSApp: App {
    init() {
        initAppKt.initKoin()
        //KoinKt.doInitKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
