import {useState, useEffect} from 'react'

export function useGoBackTo(history, path) {
    const [locationKeys, setLocationKeys] = useState([])

    useEffect(() => {
        return history.listen(location => {
            if (history.action === 'PUSH') {
                setLocationKeys([location.key])
            }

            if (history.action === 'POP') {
                if (locationKeys[1] === location.key) {
                    setLocationKeys(([_, ...keys]) => keys)

                    // Handle forward event
                    
                } else {
                    setLocationKeys((keys) => [location.key, ...keys])
                    
                    //handle back event
                    history.push(path)

                }
            }
        })
    }, [locationKeys,])

}