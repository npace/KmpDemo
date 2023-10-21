import SwiftUI
import shared

struct ContentView: View {
    let items = CheeseViewStateFakeData().cheeseViewStates
    
    var body: some View {
        List(items,
             id: \.cheeseName) {
            let item: CheeseViewState = $0
            HStack(content: {
                Text(item.cheeseName)
            })
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
